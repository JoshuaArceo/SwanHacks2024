using System;
using System.Collections.Generic;
using UnityEngine;

[Serializable]
public class PlanetData
{
    public string planetName;
    public string vector;
    public float percentError;

    public PlanetData(string planetName, string vector, float percentError)
    {
        this.planetName = planetName;
        this.vector = vector;
        this.percentError = percentError;
    }
}