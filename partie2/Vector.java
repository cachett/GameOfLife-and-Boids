import static java.lang.Math.*;



/**
*<b> Vector is a class that defines a vector
* and implements all useful operations that we can make on vector
* (scalar product, addition, substraction, norm...) <\b>
*/
class Vector {
    double x, y;

    /**
    *Constructor Vector.
    *To create a vector of null value.
    */
    Vector() {
    }

    /**
    *Constructor Vector
    *@param x
    *     The first component of the vector.
    *@param y
    *     The second component of the vector.
    */
    Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }


    /**
    *Copy of vectors.
    *@param v
    *         The vector that will be copied.
    */
    Vector(Vector v) {
        this.x = v.x;
        this.y = v.y;
    }

    /**
    *Addition of two vectors
    *@param v
    *         The vector that will be add to our actual vector.
    */
    void add(Vector v) {
        x += v.x;
        y += v.y;
    }

    /**
    *Subtraction of two vectors
    *@param v
    *         The vector that will be sustract to our actual vector.
    */
    void sub(Vector v) {
        x -= v.x;
        y -= v.y;
    }

    /**
    *Division of a vector by a double.
    *This double can't be 0.
    *@param val
    *         The value that will divided each component of the vector.
    */
    void div(double val) {
      if (val == 0){
        throw new IllegalArgumentException("division par 0 !\n");
      }
        x /= val;
        y /= val;
    }

    /**
    *Multiplication of a vector by a double.
    *@param val
    *       The value that will multiplied each component of the vector.
    */
    void mult(double val) {
        x *= val;
        y *= val;
    }

    /**
    *Return the norm of a vector
    *@return a double that is the norm of the vector.
    */
    double norm() {
        return sqrt(pow(x, 2) + pow(y, 2));
    }

    /**
    *Multiplication of two vectors : scalar product
    *@param v
    *      The vector multiplied to our actual vector.
    *@return the result of the scalar product.
    */
    double dot(Vector v) {
        return x * v.x + y * v.y;
    }

    /**
    *Normalize a vector.
    */
    void normalize() {
        double norm = norm();
        if (norm != 0) {
            x /= norm;
            y /= norm;
        }
    }

    void limit(double lim) {
        double norm = norm();
        if (norm != 0 && norm > lim) {
            x *= lim / norm;
            y *= lim / norm;
        }
    }

    double heading() {
        return atan2(y, x);
    }

    /**
    *Creation of a new Vector
    *based on the subtraction of two others vectors.
    *@param v
    *     The first element of the substraction.
    *@param v2
    *     The second element of the substraction.
    *@return a new vector that result from the substraction of the two parameters.
    */
    static Vector sub(Vector v, Vector v2) {
        return new Vector(v.x - v2.x, v.y - v2.y);
    }

    /**
    *Creation of a new Vector
    *based on the addition of two others vectors.
    *@param v
    *     The first element of the addition.
    *@param v2
    *     The second element of the addition.
    *@return a new vector that result from the addition of the two parameters.
    */
    static Vector add(Vector v, Vector v2) {
        return new Vector(v.x + v2.x, v.y + v2.y);
    }

    /**
    *Compute the distance between two vectors
    *@param v
    *      The first vector.
    *@param v2
    *      The second vector.
    *@return the distance between the two parameters.
    */
    static double dist(Vector v, Vector v2) {
        return sqrt(pow(v.x - v2.x, 2) + pow(v.y - v2.y, 2));
    }

    /**
    *Compute the angle between two vectors
    *@param v
    *      The first vector.
    *@param v2
    *      The second vector.
    *@return the angle between the two parameters.
    */
    static double angleBetween(Vector v, Vector v2) {
        return acos(v.dot(v2) / (v.norm() * v2.norm()));
    }

    @Override
    public String toString(){
      String res = "(" + x +", " + y +")";
      return res;
    }
  }
