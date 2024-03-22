

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * A classe de teste CompanyTest.
 *
 * @author  (seu nome)
 * @version (um número da versão ou uma data)
 */
public class CompanyTest
{
    private User client1;
    private User client2;
    private User seller1;
    private User seller2;
    private Company company;
    private Property property1;
    private Property property2;
    private Sell sell1;
    private Sell sell2;
    /**
     * Construtor default para a classe de teste CompanyTest
     */
    public CompanyTest()
    {
    }

    /**
     * Define a 'fixture' do teste.
     *
     * Chamado antes de cada método de caso de teste.
     */
    @BeforeEach
    public void setUp()
    {
        this.client1 = new User("José Manuel","911111111","zemanel@yahoo.com");
        this.client2 = new User("António Francisco", "922222222", "tochico@hotmail.com");
        this.seller1 = new User("Fernando Fernandes", "966777101", "fefe@remax.pt");
        this.seller2 = new User("Rodrigo Rodrigues", "966777152", "roro@remax.pt");
        this.company = new Company();
        this.property1 = new Property("T3 Monte Belo", 150000.0);
        this.property2 = new Property("T5 Monte da Caparica", 470000.0);
        this.sell1 = new Sell(client1,seller1,property1);
        this.sell2 = new Sell(client2,seller2,property2);
    }

    /**
     * Desfaz a 'fixture' do teste.
     *
     * Chamado após cada método de teste de caso.
     */
    @AfterEach
    public void tearDown()
    {
    }
    
    @Test
    public void testConstructor() {
        assertNotNull(company.getClients());
        assertNotNull(company.getSellers());
        assertNotNull(company.getProperties());
        assertNotNull(company.getSells());
    }

    @Test
    public void testRegisterClient() {
        assertTrue(company.registerClient(client1));
    }
    
    @Test
    public void testRegisterClients() {
        assertTrue(company.registerClient(client1));
        assertTrue(company.registerClient(client2));
    }
    
    @Test
    public void testRegisterClientDuplicate() {
        assertTrue(company.registerClient(client1));
        assertFalse(company.registerClient(client1));
    }
    
    @Test
    public void testRegisterClientNull() {
        assertFalse(company.registerClient(null));
    }
    
    @Test
    public void testRegisterSeller(){
        assertTrue(company.registerSeller(seller1));
    }
    
    @Test
    public void testRegisterSellers(){
        assertTrue(company.registerSeller(seller1));
        assertTrue(company.registerSeller(seller2));
    }
    
    @Test
    public void testRegisterSellerDuplicate(){
        assertTrue(company.registerSeller(seller1));
        assertFalse(company.registerSeller(seller1));
    }
    
    @Test
    public void testRegisterSellerNull(){
        assertFalse(company.registerSeller(null));
    }
    
    @Test
    public void testRegisterProperty(){
        assertTrue(company.registerProperty(property1));
    }
    
    @Test
    public void testRegisterProperties(){
        assertTrue(company.registerProperty(property1));
        assertTrue(company.registerProperty(property2));
    }
    
    @Test
    public void testRegisterPropertyDuplicate(){
        assertTrue(company.registerProperty(property1));
        assertFalse(company.registerProperty(property1));
    }
    
    @Test
    public void testRegisterPropertyNull(){
        assertFalse(company.registerProperty(null));
    }
    
    @Test
    public void testCreateSell() {
        company.registerClient(client1);
        company.registerSeller(seller1);
        company.registerProperty(property1);
        assertTrue(company.createSell(client1, seller1, property1));
    }
    
    @Test
    public void testCalculateSellsOfYear() {
        company.registerClient(client1);
        company.registerSeller(seller1);
        company.registerProperty(property1);
        company.registerClient(client2);
        company.registerSeller(seller2);
        company.registerProperty(property2);
        company.createSell(client1, seller1, property1);
        company.createSell(client2, seller2, property2);
        assertEquals(2, company.calculateSellsOfTheYear(2024));
    }
    
    
}
