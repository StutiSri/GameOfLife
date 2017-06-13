package tw.org.model;

import java.util.ArrayList;

public class TestGrid extends Grid {
    private final ArrayList<String> pattern;

    public TestGrid(ArrayList<String> pattern) {
        super(null);
        this.pattern = pattern;
    }

    @Override
    public String toString() {
        String gridOutput = "";
        for(String string : pattern)
            gridOutput += string + "\n";
        return gridOutput;
    }

    @Override
    public boolean equals(Object obj) {
        return toString().equals(obj.toString());
    }
}
