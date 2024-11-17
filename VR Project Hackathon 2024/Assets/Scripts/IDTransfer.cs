using System.Collections;
using System.Collections.Generic;
using TMPro;
using UnityEngine;

public class IDTransfer : MonoBehaviour
{
    public TextMeshProUGUI IDfield;
    // Start is called before the first frame update
    void Start()
    {
        IDfield.text = StaticData.valueToKeep;
    }

    // Update is called once per frame
    void Update()
    {
        
    }
}
