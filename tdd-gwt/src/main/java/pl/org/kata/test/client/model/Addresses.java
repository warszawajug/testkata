package pl.org.kata.test.client.model;




public class Addresses {

  private AddressDataProxy register;

  private AddressDataProxy mail;


  public Addresses(AddressDataProxy registerAddress,
      AddressDataProxy mailAddress) {

    this.register = registerAddress;
    this.mail = mailAddress;
  }


  public AddressDataProxy getRegister() {
    return register;
  }


  public void setRegister(AddressDataProxy register) {
    this.register = register;
  }


  public AddressDataProxy getMail() {
    return mail;
  }


  public void setMail(AddressDataProxy mail) {
    this.mail = mail;
  }
}
