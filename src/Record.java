public class Record extends Main{
    long id;
    String phoneNumber, name;

    public Record(long id, String phoneNumber, String name){
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.name = name;
    }

    public String getPhoneNumber(){
        return this.phoneNumber;
    }

    public void printInfo(){
        System.out.println(String.format("Номер id: %s\nНомер телефона: %s\n" +
                        "Имя: %s\n", this.id, this.phoneNumber, this.name));
    }

    @Override
    public String toString() {
        return this.phoneNumber;
    }

}
