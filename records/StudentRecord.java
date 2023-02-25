public record StudentRecord(String name, String email) {

    /* allowed to create static variable but can not
    add instance variable because records are by default
     final. */
    public static  String DEFAULT_VAR = "STATIC";

    // valdiation
    public StudentRecord{
        if(name.isBlank()){
            throw new IllegalArgumentException("can not be blank");
        }
    }
public String externalFunction(){
    return "External func";
}
}
