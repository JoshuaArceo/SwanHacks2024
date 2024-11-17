using System;
using UnityEngine;

public class PlanetData
{
    public string planetName;
    public Vector3 values;
    public float error;

    public PlanetData(string planetName, Vector3 values, float error)
    {
        this.planetName = planetName;
        this.values = values;
        this.error = error;
    }
}