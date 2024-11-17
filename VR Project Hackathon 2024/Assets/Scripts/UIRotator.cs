using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class UIRotator : MonoBehaviour
{
    public Transform cam;
    // Start is called before the first frame update
    void Start()
    {
        
    }

    // Update is called once per frame
    void Update()
    {
        GameObject[] objs = GameObject.FindGameObjectsWithTag("errUI");
        foreach (var ui in objs)
        {
            Vector3 target = new Vector3(cam.position.x, ui.transform.position.y, cam.position.z);
            ui.transform.LookAt(target);
        }
        
    }
}
