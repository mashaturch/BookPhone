import java.util.List;

public class PhoneBook {
    protected List<Record> records;

    public PhoneBook(List<Record> record) {
        this.records = record;
    }


    public List<Record> getAllRecords() {
        return this.records;
    }


    public void createRecord(Record record) throws PhoneNumberAlreadyExists{

        for (Record elem: records) {
            if (elem.getPhoneNumber().equals(record.getPhoneNumber())) {
                throw new PhoneNumberAlreadyExists("Запись с таким номером уже существует!");
            }
        }
        records.add(record);
    }

    public void printInfo() {
        System.out.println("Телефонная книга");
        for (Record record : records) {
            record.printInfo();
        }
    }

    public void updateRecord(Record record) throws RecordNotFound, RecordNotValid{
        int i = 0;
        boolean check = true;
        if (record.name.equals("")) {
            throw new RecordNotValid("Не зполнено поле имя!");
        } else if (record.phoneNumber.equals("")) {
            throw new RecordNotValid("Не заполнени номер телефона!");
        }

        for (Record record1 : records) {
            if (record.id == record1.id) {
                records.set(i, record);
                i++;
                check = false;
            }
        }

        if (check) {
            throw new RecordNotFound("Нет такого идентификатора!");
        }
    }

    public void deleteRecord(long id) {
        for (Record record : records) {
            if (id == record.id) {
                records.remove(record);
                break;
            }
        }
    }

}
