/*
Вам необходимо создать телефонный справочник для записи номеров телефонов PhoneBook, у которого должны быть
следующие методы:
* public List<Record> getAllRecords() - метод возвращает список из всех записей справочника.
* public void createRecord(Record record) - метод сохраняет в справочнике новую запись. Если в справочнике есть запись с
таким же номером телефона, выбросить проверяемое исключение PhoneNumberAlreadyExists.
* public void updateRecord(Record record) - метод обновляет запись в справочнике. Если запись с таким идентификатором
не существует, выбросить непроверяемое исключение RecordNotFound. Если в новой записи не заполнено поле name и/или
поле phoneNumber, выбросить проверяемое исключение RecordNotValid.
* public void deleteRecord(long id) - удаляет запись из справочника по идентификатору, если подходящая запись в
справочнике не найдена - выбрасывается непроверяемое исключение RecordNotFound.
Все методы работают с объектом типа Record. У него должны быть поля id (идентификатор типа long), phoneNumber (номер
телефона типа String) и поле name (имя типа String).
Все исключения создать самостоятельно. Проверяемые исключения отловить в методе main и информативно обработать.
*/


import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        PhoneBook book = new PhoneBook(new ArrayList<Record>());
        try {
            book.createRecord(new Record(1, "89133764428", "Мария"));
        } catch (PhoneNumberAlreadyExists e) {
            throw new RuntimeException(e);
        }
        try {
            book.createRecord(new Record(2, "89139160849", "Лариса"));
        } catch (PhoneNumberAlreadyExists e) {
            throw new RuntimeException(e);
        }
        try {
            book.createRecord(new Record(3, "89137541397", "Михаил"));
        } catch (PhoneNumberAlreadyExists e) {
            throw new RuntimeException(e);
        }
        book.printInfo();
        System.out.println("-------------------------");
        try {
            book.updateRecord(new Record(1,"89139133322", "Мария"));
        } catch (RecordNotFound e) {
            throw new RuntimeException(e);
        } catch (RecordNotValid e) {
            throw new RuntimeException(e);
        }

        book.printInfo();

        try {
            book.updateRecord(new Record(10,"89139133322", "Мария"));
        } catch (RecordNotFound e) {
            throw new RuntimeException(e);
        } catch (RecordNotValid e) {
            throw new RuntimeException(e);
        }

        book.printInfo();
        System.out.println("-------------------------");
        book.deleteRecord(3);
        book.printInfo();
        System.out.println("-------------------------");
        try {
            book.createRecord(new Record(6, "89139160849", "Анастасия"));
        } catch (PhoneNumberAlreadyExists e) {
            throw new RuntimeException(e);
        }

        try {
            book.createRecord(new Record(6, "89139160433", "Анастасия"));
        } catch (PhoneNumberAlreadyExists e) {
            throw new RuntimeException(e);
        }




    }
}
