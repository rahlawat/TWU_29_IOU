package com.thoughtworks.twu.persistence;

import com.thoughtworks.twu.domain.Bill;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface BillMapper {
    @Insert("INSERT INTO bill (description, amount) VALUES(#{description}, #{amount})")
    void insertBill(Bill bill);
}
