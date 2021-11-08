package javafx.controller.client;

import metier.Client;

public class ClientHolder
{
    private Client client;

    private final static ClientHolder INSTANCE = new ClientHolder();

    private ClientHolder() {}
    
    public static ClientHolder getInstance()
    {
        return INSTANCE;
    }

    public void setClient(Client client)
    {
        this.client = client;
    }

    public Client getClient()
    {
        return this.client;
    }
}
