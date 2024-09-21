
package project_store;

public class Currancy {

    private final int mCode;
    private final String mName;

    public Currancy(int mCode, String mName) {
        this.mCode = mCode;
        this.mName = mName;
    }

    @Override
    public String toString() {
        return String.format("%02d-%s", this.mCode, this.mName);
    }
}


