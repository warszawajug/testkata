/*
 * Copyright (c) 2000-2012, Efinity. All rights reserved.
 */

package pl.org.kata.test.client.model;

import com.google.web.bindery.requestfactory.shared.ValueProxy;


/**
 * @author Przemys³aw Ga³±zka
 * @since 15-06-2012
 */
//@ProxyFor(AddressData.class)
public interface AddressDataProxy extends ValueProxy {

  String getStreet();

  String getTown();

  String getZipcode();

  String getApartmentNumber();

  String getHouseNumber();

  String getPhone();

  String getFax();

  String getProvince();

  void setStreet(String value);

  void setTown(String value);

  void setZipcode(String value);

  void setApartmentNumber(String value);

  void setHouseNumber(String value);

  void setPhone(String phone);

  void setFax(String fax);

  void setProvince(String province);
}

