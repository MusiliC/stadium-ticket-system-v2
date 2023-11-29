package com.cee.tech.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

@UniqueNumber(type = UniqueNumberType.PAYMENT)
public class PaymentNoGenerator implements UniqueNoGenerator{
    @Override
    public String generate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");

        return "PMT" + dateFormat.format(new Date()) + "-" + ThreadLocalRandom.current().nextInt(2000, 3000 + 1);
    }
}
