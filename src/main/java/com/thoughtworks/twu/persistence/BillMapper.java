package com.thoughtworks.twu.persistence;

import com.thoughtworks.twu.domain.Bill;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

//job: understands the database operations of the receipt
public interface BillMapper {
    @Select("SELECT description,amount FROM bill Where description = #{description}")
    Bill getBillByDescription(String description);

    @Insert("INSERT INTO bill (description, amount) VALUES(#{description}, #{amount})")
    void insertBill(Bill bill);

}
