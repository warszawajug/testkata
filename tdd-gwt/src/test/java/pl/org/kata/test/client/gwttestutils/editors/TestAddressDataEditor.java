/*
 * Copyright (c) 2000-2013, Efinity. All rights reserved.
 */

package pl.org.kata.test.client.gwttestutils.editors;

import pl.org.kata.test.client.core.editors.EditorsModule;
import pl.org.kata.test.client.drivers.AddressDriver;
import pl.org.kata.test.client.editors.AddressDataEditor;
import pl.org.kata.test.client.model.AddressDataProxy;
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
import static org.mockito.Mockito.*;


@RunWith(JukitoGwtTestRunner.class)
@GwtModule("TestCore")
public class TestAddressDataEditor extends GwtTest {

  @Inject
  AddressDataEditor sut;


  @Test
  public void testIfEditorHasBoundToProxy(AddressDriver driver) throws Exception {

    //-------------------- GIVEN -------------------------------------------------------------------
    AddressDataProxy registerAddress = mock(AddressDataProxy.class);
    when(registerAddress.getTown()).thenReturn("Gda�sk");

    driver.initialize(sut);

    //-------------------- WHEN --------------------------------------------------------------------
    driver.edit(registerAddress);

    //-------------------- THEN --------------------------------------------------------------------
    assertThat(sut.town.getValue(), is("Gda�sk"));
  }


  @Test
  public void testIfUsersChangesAreBoundToProxy(AddressDriver driver) throws Exception {

    //-------------------- GIVEN -------------------------------------------------------------------
    AddressDataProxy registerAddress = mock(AddressDataProxy.class);
    driver.initialize(sut);
    driver.edit(registerAddress);

    //-------------------- WHEN --------------------------------------------------------------------
    Browser.fillText("Warszawa", sut.town);
    Browser.fillText("Pileckiego", sut.street);
    Browser.fillText("22", sut.houseNumber);
    Browser.fillText("A", sut.apartmentNumber);
    Browser.fillText("02-803", sut.zipcode);

    driver.flush();

    //-------------------- THEN --------------------------------------------------------------------
    verify(registerAddress).setTown("Warszawa");
    verify(registerAddress).setStreet("Pileckiego");
    verify(registerAddress).setHouseNumber("22");
    verify(registerAddress).setApartmentNumber("A");
    verify(registerAddress).setZipcode("02-803");
  }


  public static class A extends JukitoModule {

    @Override
    protected void configureTest() {
      install(new DefaultTestModule());
      install(new GinModuleAdapter(new EditorsModule()));
    }


    @Provides
    AddressDriver driver() {
      return GWT.create(AddressDriver.class);
    }
  }
}
