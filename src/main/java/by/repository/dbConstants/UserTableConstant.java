package by.repository.dbConstants;

public enum UserTableConstant {
    ID("id"),
    LOGIN("login"),
    PASSWORD ("passw");

    private String fielName;

    private UserTableConstant(String fielName) {
        this.fielName = fielName;
    }

    public String getfielName() {
        return fielName;
    }
}
