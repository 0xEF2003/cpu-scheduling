package no.ntnu.stud.publisher;

import java.util.HashMap;
import java.util.List;

import lombok.NoArgsConstructor;
import no.ntnu.stud.entity.Process;
import no.ntnu.stud.enums.ProcessEventEnum;
import no.ntnu.stud.listener.ProcessEventListener;

@NoArgsConstructor
public class ProcessEventPublisher {
    HashMap<ProcessEventEnum, List<ProcessEventListener>> listeners = new HashMap<>();

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
                    .forEach(l -> l.update(process.getProgessTime())); 
            }
            case PROCESS_FINISHED -> {}
        }
    }
}
