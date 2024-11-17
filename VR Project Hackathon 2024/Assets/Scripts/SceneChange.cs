using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

public class SceneChange : MonoBehaviour
{
    public UserManager manager;
    public void LoadActivity1()
    {
        string id = manager.getID();
        StaticData.valueToKeep = id;
        SceneManager.LoadScene("Activity1");
    }
    
    public void LoadActivity2()
    {
        string id = manager.getID();
        StaticData.valueToKeep = id;
        SceneManager.LoadScene("Activity2");
    }
}