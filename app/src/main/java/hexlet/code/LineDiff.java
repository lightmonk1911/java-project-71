package hexlet.code;

public class LineDiff {

    public Object getWas() {
        return was;
    }

    public Object getNow() {
        return now;
    }

    public LineDiffState getState() {
        return state;
    }

    private Object was;
    private Object now;
    private LineDiffState state;

    LineDiff(Object was, Object now, LineDiffState state) {
        this.was = was;
        this.now = now;
        this.state = state;
    }
}
