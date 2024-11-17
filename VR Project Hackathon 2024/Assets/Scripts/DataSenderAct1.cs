using System.Collections;
using System.Collections.Generic;
using System.Text;
using TMPro;
using UnityEngine;
using UnityEngine.Networking;
using UnityEngine.SceneManagement;
using UnityEngine.Windows;
using File = System.IO.File;

public class DataSenderAct1 : MonoBehaviour
{
    private string url = "http://localhost:5000/generate";
    public CompareScale comsc;
    public TextMeshProUGUI id;
    private string[] planetNames = new[] { "Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune" };
    // Start is called before the first frame update
    void Start()
    {
        Directory.CreateDirectory("Assets/Data");
    }

    public void SendDataToDatabase()
    {
        StartCoroutine(DataSend());
    }

    private IEnumerator DataSend()
    {
        SendData data = new SendData();
        data.userID = id.text;
        data.activityType = "Scale";
        data.planetValues = new List<PlanetData>();
        for (int i = 0; i < planetNames.Length; i++)
        {
            data.planetValues.Add(new PlanetData(planetNames[i], comsc.GetScales()[i], comsc.GetErrors()[i]));
        }
        
        string json = JsonUtility.ToJson(data, true);
        //File.WriteAllText(Application.dataPath + $"/Data/{data.userID}.json", json);

        using (UnityWebRequest request = new UnityWebRequest(url, "POST"))
        {
            byte[] bodyRaw = Encoding.UTF8.GetBytes(json);
            request.uploadHandler = new UploadHandlerRaw(bodyRaw);
            request.downloadHandler = new DownloadHandlerBuffer();
            request.SetRequestHeader("Content-Type", "application/json");
            yield return request.SendWebRequest();
            if (request.result == UnityWebRequest.Result.Success)
            {
                Debug.Log("Response: " + request.downloadHandler.text);
            }
            else
            {
                Debug.Log("Error: " + request.error);
            }
        }
    }
}