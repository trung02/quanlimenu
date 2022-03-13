/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import javaapplication1.baoDao;
import manager.bao;

/**
 *
 * @author trunghuynh
 */
public class baoService {
    private baoDao bao;
    public baoService(){
        bao = new baoDao();
    }
    public List<bao> getALLBao(){
        return bao.getALLBao();
    }
 
    public void insertBao(bao a){
        baoDao.insertBao(a);
    }
    public void UpdateBao(bao a){
        baoDao.UpdateBao(a);
    }
    public void deleteBao(bao a){
        baoDao.deleteBao(a);
    }
}
