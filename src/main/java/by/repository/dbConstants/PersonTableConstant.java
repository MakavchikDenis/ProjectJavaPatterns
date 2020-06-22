package by.repository.dbConstants;

public enum PersonTableConstant {
    NAMEL("namel"),
    SURNAMEL ("surnamel"),
    EMAIL("email");

    private String fielName;

    private PersonTableConstant(String fielName) {
        this.fielName = fielName;
    }

    public String getFielName() {
        return fielName;
    }
}
