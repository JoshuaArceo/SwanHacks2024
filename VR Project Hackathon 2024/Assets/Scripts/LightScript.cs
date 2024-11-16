using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class LightScript : MonoBehaviour
{
    private GameObject sun;
    // Start is called before the first frame update
    void Start()
    {
        //find sun by tag
        sun = GameObject.FindWithTag("Sun");
    }

    // Update is called once per frame
    void Update()
    {
        Vector3 distance = -(gameObject.transform.position-sun.transform.position)/(gameObject.transform.position-sun.transform.position).magnitude*.60f;
        gameObject.GetComponent<Renderer>().material.SetVector("_SunDir",distance);
    }
}
