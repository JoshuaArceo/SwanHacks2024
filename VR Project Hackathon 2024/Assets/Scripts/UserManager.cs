using System.Collections;
using System.Collections.Generic;using TMPro;
using UnityEngine;

public class UserManager : MonoBehaviour
{
    public TextMeshProUGUI userID;
    private string id;
    public void setID()
    {
        id = userID.text;
    }

    public string getID()
    {
        return id;
    }
}