// Generated by Dagger (https://dagger.dev).
package com.findajob.jobamax.repo;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import javax.inject.Provider;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class MessageRepository_Factory implements Factory<MessageRepository> {
  private final Provider<Context> contextProvider;

  public MessageRepository_Factory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public MessageRepository get() {
    return newInstance(contextProvider.get());
  }

  public static MessageRepository_Factory create(Provider<Context> contextProvider) {
    return new MessageRepository_Factory(contextProvider);
  }

  public static MessageRepository newInstance(Context context) {
    return new MessageRepository(context);
  }
}