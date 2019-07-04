package com.ainosoft.loginGWT.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface LoginServiceAsync
{

    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see com.ainosoft.loginGWT.client.LoginService
     */
    void greetServer( java.lang.String name, AsyncCallback<java.lang.String> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see com.ainosoft.loginGWT.client.LoginService
     */
    void add( com.ainosoft.loginGWT.client.LoginSlim loginslim, AsyncCallback<java.lang.Integer> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see com.ainosoft.loginGWT.client.LoginService
     */
    void addUserRecord( com.ainosoft.loginGWT.client.addCellTableRecord.AddUserRecordSlim addUserRecordSlim, AsyncCallback<java.lang.Integer> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see com.ainosoft.loginGWT.client.LoginService
     */
    void readAll( AsyncCallback<java.util.ArrayList<com.ainosoft.loginGWT.client.addCellTableRecord.AddUserRecordSlim>> callback );


    /**
     * Utility class to get the RPC Async interface from client-side code
     */
    public static final class Util 
    { 
        private static LoginServiceAsync instance;

        public static final LoginServiceAsync getInstance()
        {
            if ( instance == null )
            {
                instance = (LoginServiceAsync) GWT.create( LoginService.class );
            }
            return instance;
        }

        private Util()
        {
            // Utility class should not be instantiated
        }
    }
}
