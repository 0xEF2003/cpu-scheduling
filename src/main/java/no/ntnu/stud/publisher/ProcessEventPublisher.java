package no.ntnu.stud.publisher;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

import java.util.Map;
import no.ntnu.stud.entity.Process;
import no.ntnu.stud.enums.ProcessEventEnum;
import no.ntnu.stud.listener.ProcessEventListener;

public class ProcessEventPublisher {
  private Map<ProcessEventEnum, List<ProcessEventListener>> listeners =
      new EnumMap<>(ProcessEventEnum.class);

  public ProcessEventPublisher() {
    for (ProcessEventEnum event : ProcessEventEnum.values()) {
      listeners.put(event, new ArrayList<>());
    }
  }

  public void subscribe(ProcessEventEnum event, ProcessEventListener subscriber) {
    List<ProcessEventListener> subscribers = listeners.get(event);
    subscribers.add(subscriber);
  }

  public void unsubscribe(ProcessEventEnum event, ProcessEventListener subscriber) {
    List<ProcessEventListener> subscribers = listeners.get(event);
    subscribers.remove(subscriber);
  }

  public void notify(ProcessEventEnum event, Process process) {
    switch (event) {
      case PROGRESS_TIME_UPDATED -> {
        listeners.get(event)
            .stream()
            .forEach(l -> l.update(event, process));
      }
      case PROCESS_FINISHED -> {
      }
    }
  }
}
