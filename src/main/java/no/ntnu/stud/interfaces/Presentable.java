package no.ntnu.stud.interfaces;

import no.ntnu.stud.exceptions.StringPresentException;

public interface Presentable {
    public String present() throws StringPresentException;
}
