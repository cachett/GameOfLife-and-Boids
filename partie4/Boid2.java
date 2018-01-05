

class Boid2 extends Boid {

  //Constructeur de Boid
  public Boid2(double x, double y, int width, int height) {
      //a boid is caracterised by 3 vectors: acceleration, velocity and  location
    super(x, y, width, height);
    this.preferredDist = 70;
    this.desiredSeparation = 50;
    this.maxSpeed = 2.8;
  }


  public Boid2(Boid boid){
    super(boid);
    this.preferredDist = 70;
    this.desiredSeparation = 50;
    this.maxSpeed = 2.8;
  }

  //Les boids2 n'ont pas de contraintes sur les brods de l'écran
  @Override
  public Vector border(){
    return new Vector(0,0);
  }

}
