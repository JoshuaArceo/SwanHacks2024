using System.Collections;
using System.Collections.Generic;
using TMPro;
using UnityEngine;
using UnityEngine.SceneManagement;
using UnityEngine.Windows;
using File = System.IO.File;

public class DataSenderAct2 : MonoBehaviour
{
    public CompareDistance comds;
    public TextMeshProUGUI id;
    private string[] planetNames = new[] { "Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune" };
    // Start is called before the first frame update
    void Start()
    {
        Directory.CreateDirectory("Assets/Data");
    }

    public void CreateDataFile()
    {
        SendData data = new SendData();
        data.userID = id.text;
        data.activityType = "Distance";
        data.planetValues = new List<PlanetData>();
        for (int i = 0; i < planetNames.Length; i++)
        {
            data.planetValues.Add(new PlanetData(planetNames[i], comds.GetEstimatePositions()[i], comds.GetErrors()[i])); 
        }
        string json = JsonUtility.ToJson(data, true);
        File.WriteAllText(Application.dataPath + $"/Data/{data.userID}.json", json);
    }
}