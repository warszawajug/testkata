/*
 * Copyright (c) 2000-2013, Efinity. All rights reserved.
 */

package pl.org.kata.test.client.gwttestutils.editors;

import pl.org.kata.test.client.core.editors.EditorsModule;
import pl.org.kata.test.client.drivers.AddressesDriver;
import pl.org.kata.test.client.editors.AddressesEditor;
import pl.org.kata.test.client.model.AddressDataProxy;
import pl.org.kata.test.client.model.Addresses;
import pl.org.kata.test.client.modules.DefaultTestModule;

import javax.inject.Inject;
import org.jukito.JukitoModule;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.google.gwt.core.client.GWT;
import com.google.gwt.inject.rebind.adapter.GinModuleAdapter;
import com.google.inject.Provides;
import com.googlecode.gwt.test.GwtModule;
import com.googlecode.gwt.test.GwtTest;
import com.googlecode.gwt.test.jukito.JukitoGwtTestRunner;
import com.googlecode.gwt.test.utils.events.Browser;


import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


@RunWith(JukitoGwtTestRunner.class)
@GwtModule("TestCore")
public class TestTwoAddressOneDriver extends GwtTest {


  @Inject
  AddressesEditor sut;


  @Test
  public void testFlushingEditorsToProxy(AddressesDriver driver) throws Exception {

    //-------------------- GIVEN -------------------------------------------------------------------
    AddressDataProxy registerAddress = mock(AddressDataProxy.class);
    AddressDataProxy mailAddress = mock(AddressDataProxy.class);

    given(mailAddress.getTown()).willReturn("Sanok");

    Addresses addresses = new Addresses(registerAddress, mailAddress);

    driver.initialize(sut);

    //-------------------- WHEN --------------------------------------------------------------------
    driver.edit(addresses);


    //-------------------- THEN --------------------------------------------------------------------
    assertThat(sut.mail.town.getValue(), is("Sanok"));
  }


  @Test
  public void testIfUserChangesHasBoundToProxy(AddressesDriver driver) throws Exception {

    //-------------------- GIVEN -------------------------------------------------------------------
    AddressDataProxy registerAddress = mock(AddressDataProxy.class);
    AddressDataProxy mailAddress = mock(AddressDataProxy.class);

    Addresses addresses = new Addresses(registerAddress, mailAddress);

    driver.initialize(sut);
    driver.edit(addresses);

    //-------------------- WHEN --------------------------------------------------------------------
    Browser.fillText("Sanok",sut.register.town);
    Browser.fillText("430",sut.mail.apartmentNumber);

    driver.flush();

    //-------------------- THEN --------------------------------------------------------------------
    verify(registerAddress).setTown("Sanok");
    verify(mailAddress).setApartmentNumber("430");
  }



  public static class A extends JukitoModule {

    @Override
    protected void configureTest() {
      install(new DefaultTestModule());
      install(new GinModuleAdapter(new EditorsModule()));
    }


    @Provides
    AddressesDriver driver() {
      return GWT.create(AddressesDriver.class);
    }
  }


}
