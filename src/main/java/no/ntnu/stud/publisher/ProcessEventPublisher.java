package no.ntnu.stud.publisher;

import java.util.HashMap;
import java.util.List;

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

    //public void notify(ProcessEventEnum event, )
}
