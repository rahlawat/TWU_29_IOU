package com.thoughtworks.twu.service;

import com.thoughtworks.twu.domain.Bill;
import com.thoughtworks.twu.persistence.BillMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillService {
    private BillMapper billMapper;

    @Autowired
    public BillService(BillMapper billMapper) {
        this.billMapper = billMapper;
    }

    public void insertBill(Bill bill){
        billMapper.insertBill(bill);
    }

    public Bill getBill(String description) {
        return billMapper.getBillByDescription(description);
    }
}
