package org.infinispan.test.integration.security.utils;

import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.sasl.AuthorizeCallback;
import javax.security.sasl.RealmCallback;

/**
 * 
 * @author vjuranek
 * @since 7.0
 */
public class SaslPropCallbackHandler implements CallbackHandler {

   private final String name;
   private final char[] password;
   private final String realm;

   public SaslPropCallbackHandler() {
      this.name = System.getProperty("sasl.username");
      this.password = System.getProperty("sasl.password").toCharArray();
      this.realm = System.getProperty("sasl.realm");
   }

   @Override
   public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
      for (Callback callback : callbacks) {
         if (callback instanceof PasswordCallback) {
            ((PasswordCallback) callback).setPassword(password);
         } else if (callback instanceof NameCallback) {
            ((NameCallback) callback).setName(name);
         } else if (callback instanceof AuthorizeCallback) {
            AuthorizeCallback authorizeCallback = (AuthorizeCallback) callback;
            authorizeCallback.setAuthorized(authorizeCallback.getAuthenticationID().equals(
                  authorizeCallback.getAuthorizationID()));
         } else if (callback instanceof RealmCallback) {
            RealmCallback realmCallback = (RealmCallback) callback;
            realmCallback.setText(realm);
         } else {
            throw new UnsupportedCallbackException(callback);
         }
      }
   }

}
