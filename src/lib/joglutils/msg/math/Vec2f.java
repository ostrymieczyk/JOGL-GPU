/*
 * Copyright (c) 2007 Sun Microsystems, Inc. All Rights Reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 * 
 * - Redistribution of source code must retain the above copyright
 *   notice, this list of conditions and the following disclaimer.
 * 
 * - Redistribution in binary form must reproduce the above copyright
 *   notice, this list of conditions and the following disclaimer in the
 *   documentation and/or other materials provided with the distribution.
 * 
 * Neither the name of Sun Microsystems, Inc. or the names of
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 * 
 * This software is provided "AS IS," without a warranty of any kind. ALL
 * EXPRESS OR IMPLIED CONDITIONS, REPRESENTATIONS AND WARRANTIES,
 * INCLUDING ANY IMPLIED WARRANTY OF MERCHANTABILITY, FITNESS FOR A
 * PARTICULAR PURPOSE OR NON-INFRINGEMENT, ARE HEREBY EXCLUDED. SUN
 * MICROSYSTEMS, INC. ("SUN") AND ITS LICENSORS SHALL NOT BE LIABLE FOR
 * ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING OR
 * DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES. IN NO EVENT WILL SUN OR
 * ITS LICENSORS BE LIABLE FOR ANY LOST REVENUE, PROFIT OR DATA, OR FOR
 * DIRECT, INDIRECT, SPECIAL, CONSEQUENTIAL, INCIDENTAL OR PUNITIVE
 * DAMAGES, HOWEVER CAUSED AND REGARDLESS OF THE THEORY OF LIABILITY,
 * ARISING OUT OF THE USE OF OR INABILITY TO USE THIS SOFTWARE, EVEN IF
 * SUN HAS BEEN ADVISED OF THE POSSIBILITY OF SUCH DAMAGES.
 * 
 * You acknowledge that this software is not designed or intended for use
 * in the design, construction, operation or maintenance of any nuclear
 * facility.
 * 
 */

package lib.joglutils.msg.math;

/** 2-element single-precision vector */

public class Vec2f {
  private float x;
  private float y;

  public Vec2f() {}

  public Vec2f(Vec2f arg) {
    this(arg.x, arg.y);
  }

  public Vec2f(float x, float y) {
    set(x, y);
  }

  public Vec2f copy() {
    return new Vec2f(this);
  }

  public void set(Vec2f arg) {
    set(arg.x, arg.y);
  }

  public void set(float x, float y) {
    this.x = x;
    this.y = y;
  }

  /** Sets the ith component, 0 <= i < 2 */
  public void set(int i, float val) {
    switch (i) {
    case 0: x = val; break;
    case 1: y = val; break;
    default: throw new IndexOutOfBoundsException();
    }
  }

  /** Gets the ith component, 0 <= i < 2 */
  public float get(int i) {
    switch (i) {
    case 0: return x;
    case 1: return y;
    default: throw new IndexOutOfBoundsException();
    }
  }

  public float x() { return x; }
  public float y() { return y; }

  public void setX(float x) { this.x = x; }
  public void setY(float y) { this.y = y; }

  public float dot(Vec2f arg) {
    return x * arg.x + y * arg.y;
  }

  public float length() {
    return (float) Math.sqrt(lengthSquared());
  }

  public float lengthSquared() {
    return this.dot(this);
  }

  public void normalize() {
    float len = length();
    if (len == 0.0f) return;
    scale(1.0f / len);
  }

  /** Returns this * val; creates new vector */
  public Vec2f times(float val) {
    Vec2f tmp = new Vec2f(this);
    tmp.scale(val);
    return tmp;
  }

  /** this = this * val */
  public void scale(float val) {
    x *= val;
    y *= val;
  }

  /** Returns this + arg; creates new vector */
  public Vec2f plus(Vec2f arg) {
    Vec2f tmp = new Vec2f();
    tmp.add(this, arg);
    return tmp;
  }

  /** this = this + b */
  public void add(Vec2f b) {
    add(this, b);
  }

  /** this = a + b */
  public void add(Vec2f a, Vec2f b) {
    x = a.x + b.x;
    y = a.y + b.y;
  }

  /** Returns this + s * arg; creates new vector */
  public Vec2f addScaled(float s, Vec2f arg) {
    Vec2f tmp = new Vec2f();
    tmp.addScaled(this, s, arg);
    return tmp;
  }

  /** this = a + s * b */
  public void addScaled(Vec2f a, float s, Vec2f b) {
    x = a.x + s * b.x;
    y = a.y + s * b.y;
  }

  /** Returns this - arg; creates new vector */
  public Vec2f minus(Vec2f arg) {
    Vec2f tmp = new Vec2f();
    tmp.sub(this, arg);
    return tmp;
  }

  /** this = this - b */
  public void sub(Vec2f b) {
    sub(this, b);
  }

  /** this = a - b */
  public void sub(Vec2f a, Vec2f b) {
    x = a.x - b.x;
    y = a.y - b.y;
  }

  public Vecf toVecf() {
    Vecf out = new Vecf(2);
    for (int i = 0; i < 2; i++) {
      out.set(i, get(i));
    }
    return out;
  }

  public String toString() {
    return "(" + x + ", " + y + ")";
  }
}