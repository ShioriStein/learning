package core.accessmod.p1;

//Public class
public class PublicClass1 {
    public String publicAttr1 = "publicAttr1";
    private String privateAttr1 = "privateAttr1";
    String defaultAttr1 = "defaultAttr1";
    protected String protectedAttr1 = "protectedAttr1";
    
    public String getPrivateAttr1() {
        return privateAttr1;
    }

    public void setPrivateAttr1(String privateAttr1) {
        this.privateAttr1 = privateAttr1;
    }
}
