package com.github.matek2305.gop.test;

import java.math.BigInteger;
import java.time.LocalDate;

/**
 * @author Mateusz Urbański <matek2305@gmail.com>.
 */
public class SimplePojo {

    private String string;
    private LocalDate localDate;
    private boolean bool;
    private BigInteger bigInteger;
    private long longPrimitive;

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
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
                ", localDate=" + localDate +
                ", bool=" + bool +
                ", bigInteger=" + bigInteger +
                ", longPrimitive=" + longPrimitive +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SimplePojo that = (SimplePojo) o;

        if (bool != that.bool) return false;
        if (longPrimitive != that.longPrimitive) return false;
        if (string != null ? !string.equals(that.string) : that.string != null) return false;
        if (localDate != null ? !localDate.equals(that.localDate) : that.localDate != null)
            return false;
        return bigInteger != null ? bigInteger.equals(that.bigInteger) : that.bigInteger == null;

    }

    @Override
    public int hashCode() {
        int result = string != null ? string.hashCode() : 0;
        result = 31 * result + (localDate != null ? localDate.hashCode() : 0);
        result = 31 * result + (bool ? 1 : 0);
        result = 31 * result + (bigInteger != null ? bigInteger.hashCode() : 0);
        result = 31 * result + (int) (longPrimitive ^ (longPrimitive >>> 32));
        return result;
    }
}
