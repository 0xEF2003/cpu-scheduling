package no.ntnu.stud.factory;

import java.util.List;
import java.util.Random;

import no.ntnu.stud.publisher.ProcessEventPublisher;

import java.util.ArrayList;


public class ProcessEventPublisherFactory {
    public static List<ProcessEventPublisher> createN(int amountOfPublishers) {
        List<ProcessEventPublisher> publishers = new ArrayList<>();

        int i = 0;
        while (i < amountOfPublishers) {
            ProcessEventPublisher publisher = new ProcessEventPublisher();
            publishers.add(publisher);
            i++;
        }

        return publishers;
    }
}
