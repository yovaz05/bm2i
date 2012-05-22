package com.bm2i.action;

import javax.ejb.Local;

@Local
public interface Authenticator {

    boolean authenticate();

}
