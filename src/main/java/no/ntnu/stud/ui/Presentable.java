package no.ntnu.stud.ui;

import no.ntnu.stud.exceptions.StringPresentException;

public interface Presentable {
    public String present() throws StringPresentException;
}
