package subito.kata.java;

import static java.util.Collections.emptyList;

public class InputBuilder {

    public Input noRoom() {
        return new Input(emptyList(), null, emptyList());
    }
}
