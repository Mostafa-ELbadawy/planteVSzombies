/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.allObjects;

import com.jme3.animation.AnimControl;
import com.jme3.animation.LoopMode;
import com.jme3.asset.AssetManager;
import com.jme3.bullet.PhysicsSpace;
import com.jme3.bullet.collision.PhysicsCollisionObject;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.effect.ParticleEmitter;
import com.jme3.effect.ParticleMesh;
import com.jme3.effect.shapes.EmitterSphereShape;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.FastMath;
import com.jme3.math.Quaternion;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import java.util.HashMap;

/**
 *
 * @author DELL
 */
public class Bomb extends Attackers {

    public Bomb(AssetManager asset) {
        super(asset);
         Node node = (Node) assetManager.loadModel("Blender/Green_plant/plant.j3o");
        this.node = node;
        this.node.setName("plant");
        node.setLocalScale(5f);

        name = "MocapGuy_Teeth";
        Node zomb = (Node) node.getChild(name);
        control = zomb.getControl(AnimControl.class);
        channal = control.createChannel();

        phyControl = new RigidBodyControl(0);

        phyControl.removeCollideWithGroup(PhysicsCollisionObject.COLLISION_GROUP_01);
        phyControl.setCollisionGroup(PhysicsCollisionObject.COLLISION_GROUP_02);
        phyControl.addCollideWithGroup(PhysicsCollisionObject.COLLISION_GROUP_02);

        this.node.addControl(phyControl);

        this.node.rotate(0, (float) Math.PI / 2, 0);
    }
   

    @Override
    public void setstatus(float tpf, float timeNow, PhysicsSpace space, HashMap<Geometry, Bullet> hashing) {
          if (channal.getAnimationName()==null||!channal.getAnimationName().equals("attacking")) {
            channal.setAnim("attacking");
            channal.setLoopMode(LoopMode.DontLoop);
        }

    }

}
