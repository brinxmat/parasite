/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.deichman.ls.consumer;

/**
 *
 * @author sbd
 */
public interface JSONClient {

    public void openConnection(String url);

    public String connect(String url);

    public String getResponse();

}
