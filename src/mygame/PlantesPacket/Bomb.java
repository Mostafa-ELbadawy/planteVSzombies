/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.PlantesPacket;

import com.jme3.animation.AnimControl;
import com.jme3.animation.LoopMode;
import com.jme3.asset.AssetManager;
import com.jme3.bullet.PhysicsSpace;
import com.jme3.bullet.collision.PhysicsCollisionObject;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import java.util.HashMap;
import mygame.allObjects.Bullet;

/**
 *
 * @author DELL
 */
public class Bomb extends Attackers {
private static Node model;
    public Bomb() {
        super();
        Node node = (Node) model.clone();
        this.node = node;

        
        name = "plant";
        Node zomb = (Node) node.getChild(name);
        control = zomb.getControl(AnimControl.class);
        channal = control.createChannel();
         phyControl = node.getControl(RigidBodyControl.class);

       

    }

    @Override
    public void setstatus(float tpf, float timeNow, PhysicsSpace space, HashMap<Geometry, Bullet> hashing) {
        attack(timeNow, space, hashing);
    }

    @Override
    public void attack(float timeNow, PhysicsSpace space, HashMap<Geometry, Bullet> hashing) {
        if (channal.getAnimationName() == null || !channal.getAnimationName().equals("attacking")) {
            channal.setAnim("attacking");
            channal.setLoopMode(LoopMode.DontLoop);
            channal.setSpeed(3f);
        }
    }
    public static void loadmodle(AssetManager asset) {
           
           assetManager=asset;
           model=(Node) assetManager.loadModel("Blender/Bomb/bomb.j3o");
       
        model.setName("plant");
        model.setLocalScale(0.4f);
        model.rotate(0, (float) Math.PI / 2, 0);
       
        RigidBodyControl phyControl = new RigidBodyControl(0);
        phyControl.removeCollideWithGroup(PhysicsCollisionObject.COLLISION_GROUP_01);
        phyControl.setCollisionGroup(PhysicsCollisionObject.COLLISION_GROUP_02);
        phyControl.addCollideWithGroup(PhysicsCollisionObject.COLLISION_GROUP_02);
        model.addControl(phyControl);
    }


}
