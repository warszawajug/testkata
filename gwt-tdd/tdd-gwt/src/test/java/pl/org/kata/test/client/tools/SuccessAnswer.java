/*
 * Copyright (c) 2000-2012, Efinity. All rights reserved.
 */

package pl.org.kata.test.client.tools;

import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * @author Przemysław Gałązka
 * @since 06-08-2012
 */
public class SuccessAnswer<T> implements Answer<T> {

  private final T result;
  private AsyncCallback callback;


  public SuccessAnswer(T result) {
    this.result = result;
  }


  @SuppressWarnings("unchecked")
  public T answer(InvocationOnMock invocation) {
    Object[] arguments = invocation.getArguments();
    callback = (AsyncCallback<Object>) arguments[arguments.length - 1];
    callback.onSuccess(result);
    return null;
  }

}
