package com.emb.carrental.res;

import com.emb.carrental.util.LOG;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author bu_000
 */
public class CarRentalResourceIT {

    private Client client;
    private WebTarget webTarget;

    @Before
    public void initClient() {
        this.client = ClientBuilder.newClient();
        webTarget = this.client.target("http://localhost:8888/CarRental/api/CarRental/calculateTotalExpense");
    }

    @Test
    public void calculateTotalExpense() {
        Response response = webTarget.request().get();
        assertThat(response.getStatus(), is(200));
        String totalExpense = response.readEntity(String.class);
        LOG.info(totalExpense);
    }
}
