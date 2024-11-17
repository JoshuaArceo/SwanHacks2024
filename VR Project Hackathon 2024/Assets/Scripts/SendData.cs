using System;
using System.Collections;
using System.Collections.Generic;
using UnityEngine;

[Serializable]
public class SendData
{
    public string userID;
    public string activityType;
    public List<PlanetData> planetValues;
}