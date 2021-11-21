/**
 * A Rational class that supports basic arithmetic and simplification.
 */

import java.lang.Math;

class Rational {
    /**
     * The numerator.
     */
    long num;

    /**
     * The denominator. Cannot be 0.
     */
    long denom;

    /**
     * Computes the GCD of the inputs using the Euclidean algorithm.
     */
    static long gcd(long a, long b) {
        if (a < 0) {
            return gcd(-a, b);
        } else if (b < 0) {
            return gcd(a, -b);
        } else {
            if (b == 0) {
                return a;
            } else {
                return gcd(b, a % b);
            }
        }
    }

    /**
     * Computes the least commmon multiple of the inputs.
     */
    static long lcm(long a, long b) {
        return Math.abs(a / gcd(a, b) * b);
    }

    Rational(long num, long denom) throws IllegalArgumentException {
        if (denom == 0) {
            throw new IllegalArgumentException("Denominator cannot be 0");
        } else {
            // keep in simplest form
            long gcd = gcd(num, denom);
            this.num = num / gcd;
            this.denom = denom / gcd;
        }
    }

    @Override
    public String toString() {
        if (this.denom == 1) {
            return String.format("%d", this.num);
        } else {
            return String.format("%d / %d", this.num, this.denom);
        }
    }

    /**
     * Returns the sum of two rationals.
     */
    Rational add(Rational other) {
        long lcm = lcm(this.denom, other.denom);
        // what we multiply each fraction by
        long coef1 = lcm / this.denom;
        long coef2 = lcm / other.denom;
        return new Rational(
            this.num * coef1 + other.num * coef2,
            lcm
        );
    }

    /**
     * Returns the product of two rationals.
     */
    Rational mult(Rational other) {
        return new Rational(
            this.num * other.num,
            this.denom * other.denom
        );
    }

    /**
     * Returns the reciprocal of the rational.
     * @throws IllegalArgumentException if the rational is 0
     */
    Rational inv() {
        if (this.num == 0) {
            throw new IllegalArgumentException("Numerator cannot be 0");
        } else {
            return new Rational(this.denom, this.num);
        }
    }
}