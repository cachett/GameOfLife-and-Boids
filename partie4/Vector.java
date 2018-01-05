import static java.lang.Math.*;

class Vector {
    double x, y;

    Vector() {
    }
    //Constructeur de Vector
    Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }


    /**
    *Copy of vectors
    */
    Vector(Vector v) {
        this.x = v.x;
        this.y = v.y;
    }

    /**
    *Addition of two vectors
    */
    void add(Vector v) {
        x += v.x;
        y += v.y;
    }

    /**
    *Subtraction of two vectors
    */
    void sub(Vector v) {
        x -= v.x;
        y -= v.y;
    }

    /**
    *Division of a vector by a double
    */
    void div(double val) {
      if (val == 0){
        throw new IllegalArgumentException("division par 0 !\n");
      }
        x /= val;
        y /= val;
    }

    /**
    *Multiplication of a vector by a double
    */
    void mult(double val) {
        x *= val;
        y *= val;
    }

    /**
    *Return the norm of a vector
    */
    double norm() {
        return sqrt(pow(x, 2) + pow(y, 2));
    }

    /**
    *Multiplication of two vectors : scalar product
    */
    double dot(Vector v) {
        return x * v.x + y * v.y;
    }

    /**
    *Normalize a vector
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
    *based on the subtraction of two others vectors
    */
    static Vector sub(Vector v, Vector v2) {
        return new Vector(v.x - v2.x, v.y - v2.y);
    }

    /**
    *Return the distance between two vectors
    */
    static double dist(Vector v, Vector v2) {
        return sqrt(pow(v.x - v2.x, 2) + pow(v.y - v2.y, 2));
    }

    /**
    *Return the angle between two vectors
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
