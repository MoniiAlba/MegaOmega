
package tablewssc;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the tablewssc package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CreateTable_QNAME = new QName("http://wsstable/", "createTable");
    private final static QName _CreateTableResponse_QNAME = new QName("http://wsstable/", "createTableResponse");
    private final static QName _DeleteRecord_QNAME = new QName("http://wsstable/", "deleteRecord");
    private final static QName _DeleteRecordResponse_QNAME = new QName("http://wsstable/", "deleteRecordResponse");
    private final static QName _GetFields_QNAME = new QName("http://wsstable/", "getFields");
    private final static QName _GetFieldsResponse_QNAME = new QName("http://wsstable/", "getFieldsResponse");
    private final static QName _GetRecords_QNAME = new QName("http://wsstable/", "getRecords");
    private final static QName _GetRecordsResponse_QNAME = new QName("http://wsstable/", "getRecordsResponse");
    private final static QName _Hello_QNAME = new QName("http://wsstable/", "hello");
    private final static QName _HelloResponse_QNAME = new QName("http://wsstable/", "helloResponse");
    private final static QName _InsertRecord_QNAME = new QName("http://wsstable/", "insertRecord");
    private final static QName _InsertRecordResponse_QNAME = new QName("http://wsstable/", "insertRecordResponse");
    private final static QName _UpdateRecord_QNAME = new QName("http://wsstable/", "updateRecord");
    private final static QName _UpdateRecordResponse_QNAME = new QName("http://wsstable/", "updateRecordResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: tablewssc
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CreateTable }
     * 
     */
    public CreateTable createCreateTable() {
        return new CreateTable();
    }

    /**
     * Create an instance of {@link CreateTableResponse }
     * 
     */
    public CreateTableResponse createCreateTableResponse() {
        return new CreateTableResponse();
    }

    /**
     * Create an instance of {@link DeleteRecord }
     * 
     */
    public DeleteRecord createDeleteRecord() {
        return new DeleteRecord();
    }

    /**
     * Create an instance of {@link DeleteRecordResponse }
     * 
     */
    public DeleteRecordResponse createDeleteRecordResponse() {
        return new DeleteRecordResponse();
    }

    /**
     * Create an instance of {@link GetFields }
     * 
     */
    public GetFields createGetFields() {
        return new GetFields();
    }

    /**
     * Create an instance of {@link GetFieldsResponse }
     * 
     */
    public GetFieldsResponse createGetFieldsResponse() {
        return new GetFieldsResponse();
    }

    /**
     * Create an instance of {@link GetRecords }
     * 
     */
    public GetRecords createGetRecords() {
        return new GetRecords();
    }

    /**
     * Create an instance of {@link GetRecordsResponse }
     * 
     */
    public GetRecordsResponse createGetRecordsResponse() {
        return new GetRecordsResponse();
    }

    /**
     * Create an instance of {@link Hello }
     * 
     */
    public Hello createHello() {
        return new Hello();
    }

    /**
     * Create an instance of {@link HelloResponse }
     * 
     */
    public HelloResponse createHelloResponse() {
        return new HelloResponse();
    }

    /**
     * Create an instance of {@link InsertRecord }
     * 
     */
    public InsertRecord createInsertRecord() {
        return new InsertRecord();
    }

    /**
     * Create an instance of {@link InsertRecordResponse }
     * 
     */
    public InsertRecordResponse createInsertRecordResponse() {
        return new InsertRecordResponse();
    }

    /**
     * Create an instance of {@link UpdateRecord }
     * 
     */
    public UpdateRecord createUpdateRecord() {
        return new UpdateRecord();
    }

    /**
     * Create an instance of {@link UpdateRecordResponse }
     * 
     */
    public UpdateRecordResponse createUpdateRecordResponse() {
        return new UpdateRecordResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateTable }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsstable/", name = "createTable")
    public JAXBElement<CreateTable> createCreateTable(CreateTable value) {
        return new JAXBElement<CreateTable>(_CreateTable_QNAME, CreateTable.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateTableResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsstable/", name = "createTableResponse")
    public JAXBElement<CreateTableResponse> createCreateTableResponse(CreateTableResponse value) {
        return new JAXBElement<CreateTableResponse>(_CreateTableResponse_QNAME, CreateTableResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteRecord }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsstable/", name = "deleteRecord")
    public JAXBElement<DeleteRecord> createDeleteRecord(DeleteRecord value) {
        return new JAXBElement<DeleteRecord>(_DeleteRecord_QNAME, DeleteRecord.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteRecordResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsstable/", name = "deleteRecordResponse")
    public JAXBElement<DeleteRecordResponse> createDeleteRecordResponse(DeleteRecordResponse value) {
        return new JAXBElement<DeleteRecordResponse>(_DeleteRecordResponse_QNAME, DeleteRecordResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFields }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsstable/", name = "getFields")
    public JAXBElement<GetFields> createGetFields(GetFields value) {
        return new JAXBElement<GetFields>(_GetFields_QNAME, GetFields.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFieldsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsstable/", name = "getFieldsResponse")
    public JAXBElement<GetFieldsResponse> createGetFieldsResponse(GetFieldsResponse value) {
        return new JAXBElement<GetFieldsResponse>(_GetFieldsResponse_QNAME, GetFieldsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRecords }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsstable/", name = "getRecords")
    public JAXBElement<GetRecords> createGetRecords(GetRecords value) {
        return new JAXBElement<GetRecords>(_GetRecords_QNAME, GetRecords.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRecordsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsstable/", name = "getRecordsResponse")
    public JAXBElement<GetRecordsResponse> createGetRecordsResponse(GetRecordsResponse value) {
        return new JAXBElement<GetRecordsResponse>(_GetRecordsResponse_QNAME, GetRecordsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Hello }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsstable/", name = "hello")
    public JAXBElement<Hello> createHello(Hello value) {
        return new JAXBElement<Hello>(_Hello_QNAME, Hello.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HelloResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsstable/", name = "helloResponse")
    public JAXBElement<HelloResponse> createHelloResponse(HelloResponse value) {
        return new JAXBElement<HelloResponse>(_HelloResponse_QNAME, HelloResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertRecord }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsstable/", name = "insertRecord")
    public JAXBElement<InsertRecord> createInsertRecord(InsertRecord value) {
        return new JAXBElement<InsertRecord>(_InsertRecord_QNAME, InsertRecord.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertRecordResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsstable/", name = "insertRecordResponse")
    public JAXBElement<InsertRecordResponse> createInsertRecordResponse(InsertRecordResponse value) {
        return new JAXBElement<InsertRecordResponse>(_InsertRecordResponse_QNAME, InsertRecordResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateRecord }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsstable/", name = "updateRecord")
    public JAXBElement<UpdateRecord> createUpdateRecord(UpdateRecord value) {
        return new JAXBElement<UpdateRecord>(_UpdateRecord_QNAME, UpdateRecord.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateRecordResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsstable/", name = "updateRecordResponse")
    public JAXBElement<UpdateRecordResponse> createUpdateRecordResponse(UpdateRecordResponse value) {
        return new JAXBElement<UpdateRecordResponse>(_UpdateRecordResponse_QNAME, UpdateRecordResponse.class, null, value);
    }

}
