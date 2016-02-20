package com.github.matek2305.gop;

import java.math.BigInteger;
import java.time.LocalDateTime;

/**
 * @author Mateusz Urbański <matek2305@gmail.com>.
 */
public class SimplePojo {

    private String string;
    private LocalDateTime localDateTime;
    private boolean bool;
    private BigInteger bigInteger;
    private long longPrimitive;

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public boolean isBool() {
        return bool;
    }

    public void setBool(boolean bool) {
        this.bool = bool;
    }

    public BigInteger getBigInteger() {
        return bigInteger;
    }

    public void setBigInteger(BigInteger bigInteger) {
        this.bigInteger = bigInteger;
    }

    public long getLongPrimitive() {
        return longPrimitive;
    }

    public void setLongPrimitive(long longPrimitive) {
        this.longPrimitive = longPrimitive;
    }

    @Override
    public String toString() {
        return "SimplePojo{" +
                "string='" + string + '\'' +
                ", localDateTime=" + localDateTime +
                ", bool=" + bool +
                ", bigInteger=" + bigInteger +
                ", longPrimitive=" + longPrimitive +
                '}';
    }
}
